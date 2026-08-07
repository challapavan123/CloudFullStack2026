import Product from "../schema/productSchema.js";
// export const createProduct = async (productData: IProduct): Promise<IProduct> => {
//     const product = new Product(productData);
//     return await product.save();
// };  
export const getAllProducts = async () => {
    return await Product.find();
};
//# sourceMappingURL=productService.js.map