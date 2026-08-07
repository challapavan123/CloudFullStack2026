import express from "express";
const router = express.Router();
import { getAllProducts } from "../service/productService.js";
router.route("/").get(async (req, res) => {
    try {
        const products = await getAllProducts();
        res.json(products);
    }
    catch (error) {
        console.error("Error fetching products:", error);
        res.status(500).json({ error: "Internal server error" });
    }
});
export default router;
//# sourceMappingURL=productRouter.js.map