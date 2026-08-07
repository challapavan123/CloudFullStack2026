export default interface IProduct  {
    _id: string;
    id: string;
    name: string;
    description: string;
    price: number;
    productCode: string;
    rating?: number;
    imageUrl: string;
    productAvailable?: string;
    
}