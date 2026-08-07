import mongoose from "mongoose";
const productSchema = new mongoose.Schema({
    name: { type: String, required: true },
    description: { type: String, required: true },
    price: { type: Number, required: true },
    productCode: { type: String, required: true },
    rating: { type: Number, required: false },
    imageUrl: { type: String, required: true },
    // productAvailable: { type: String, required: true }
});
const Product = mongoose.model("Product", productSchema);
export default Product;
//# sourceMappingURL=productSchema.js.map