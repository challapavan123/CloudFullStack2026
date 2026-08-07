import { Document, ObjectId } from 'mongoose';
export default interface IProduct extends Document {
    id: ObjectId;
    name: string;
    description: string;
    price: number;
    productCode: string;
    rating?: number;
    imageUrl: string;
    productAvailable?: string;
}
//# sourceMappingURL=product.d.ts.map