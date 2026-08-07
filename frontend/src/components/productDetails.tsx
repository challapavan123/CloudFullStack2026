import { useState, useEffect } from "react";
import {useParams} from "react-router-dom";
import type IProduct from "../model/product";
export const ProductDetails:React.FC = () => {

    const [product, setProduct] = useState<IProduct | null>(null);
    const { id } = useParams<{ id: string }>();

    useEffect(() => {
        // Fetch product details from the backend API
        const fetchProductDetails = async () => {
            try {
                const response = await fetch('http://localhost:5000/api/products/:id'); // Replace with your backend API endpoint
                const data = await response.json();
                setProduct(data); // Log the fetched product details
            } catch (error) {
                console.error('Error fetching product details:', error);
            }
        };

        fetchProductDetails();
    }, [id]);

    return (
        <div className="container mt-4">
            <h1>Product Details</h1>
            <p>This is the product details page.</p>
        </div>
    );
}