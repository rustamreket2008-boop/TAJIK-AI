const express = require("express");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json({ limit: "1mb" }));

app.get("/", (req, res) => {
    res.json({
        name: "TAJIK AI SERVER",
        status: "online"
    });
});

app.post("/chat", async (req, res) => {
    try {
        const message = req.body.message;

        if (!message || typeof message !== "string") {
            return res.status(400).json({
                error: "Паём холӣ аст"
            });
        }

        if (message.length > 10000) {
            return res.status(400).json({
                error: "Паём хеле дароз аст"
            });
        }

        if (!process.env.OPENAI_API_KEY) {
            return res.status(503).json({
                error: "AI API ҳоло танзим нашудааст"
            });
        }

        const response = await fetch(
            "https://api.openai.com/v1/responses",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization":
                        `Bearer ${process.env.OPENAI_API_KEY}`
                },
                body: JSON.stringify({
                    model: "gpt-5.5",
                    instructions:
                        "Ту TAJIK AI ҳастӣ. Ба саволҳо равшан, муфид ва асосан ба забони тоҷикӣ ҷавоб деҳ.",
                    input: message
                })
            }
        );

        const data = await response.json();

        if (!response.ok) {
            console.error("AI API error:", data);
            return res.status(502).json({
                error: "Хатогӣ ҳангоми гирифтани ҷавоб аз AI"
            });
        }

        res.json({
            reply: data.output_text || "Ҷавоб дастрас нест."
        });

    } catch (error) {
        console.error(error);

        res.status(500).json({
            error: "Хатогии сервер"
        });
    }
});

const PORT = process.env.PORT || 3000;

app.listen(PORT, "0.0.0.0", () => {
    console.log(`TAJIK AI server running on port ${PORT}`);
});
      
