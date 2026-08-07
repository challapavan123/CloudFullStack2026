import express from "express";
import productRouter from "./router/productRouter.js";
import { connectDB } from "./config/dbConfig.js";
const app = express();
const PORT = process.env.PORT || 5001;
app.use(express.json());
app.use("/api/products", productRouter);
connectDB("mongodb+srv://admin:admin@expresscluster.pcaruhd.mongodb.net/productsdb")
    .then(() => {
    console.log("Connected to MongoDB");
    app.listen(PORT, () => {
        console.log(`Server is running on port ${PORT}`);
    });
})
    .catch((error) => {
    console.error("Error connecting to MongoDB:", error);
    process.exit(1); // Exit the process with failure
});
//# sourceMappingURL=server.js.map