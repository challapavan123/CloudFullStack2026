import mongoose from "mongoose";
import IProduct from "../model/product.js";
declare const Product: mongoose.Model<IProduct, {}, {}, {}, mongoose.Document<unknown, {}, IProduct, {}, mongoose.DefaultSchemaOptions> & IProduct & Required<{
    _id: mongoose.Types.ObjectId;
}> & {
    __v: number;
}, any, IProduct>;
export default Product;
//# sourceMappingURL=productSchema.d.ts.map