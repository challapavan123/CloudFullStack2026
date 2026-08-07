import  express  from "express";
const router = express.Router();
import {getAllProducts, getProductById} from "../service/productService.js";
import { Request,Response } from "express";
router.route("/").get(async (req: Request, res: Response) => {
    try {
        const products = await getAllProducts();
        res.json(products);
    } catch (error) {
        console.error("Error fetching products:", error);
        res.status(500).json({ error: "Internal server error" });
    }
});
    router.route("/:id").get(async (req: Request, res: Response) => {
        const rawId = req.params.id;
        const id = Array.isArray(rawId) ? rawId[0] : rawId;
        if (!id) {
            return res.status(400).json({ error: "Product id is required" });
        }
        try {
            const product = await getProductById(id);
            if (product) {
                res.json(product);
            } else {
                res.status(404).json({ error: "Product not found" });
            }
        } catch (error) {
            console.error("Error fetching product:", error);
            res.status(500).json({ error: "Internal server error" });
        }
}); 
export default router;