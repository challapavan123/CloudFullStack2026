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
                const response = await fetch(`http://localhost:5001/api/products/${id}`); // Replace with your backend API endpoint
                const data = await response.json();
                setProduct(data); // Log the fetched product details
            } catch (error) {
                console.error('Error fetching product details:', error);
            }
        };

        fetchProductDetails();
    }, [id]);

    if (!product) {
        return (
            <div className="container mt-4">
                <div className="row justify-content-center">
                    <div className="col-md-8">
                        <div className="card shadow-lg border-0">
                            <div className="card-body">
                                Loading product details...
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

    return (
        <div className="container mt-4">
           <div className="row justify-content-center">
        <div className="col-md-8">
          <div className="card shadow-lg border-0">

            {/* Header */}
            <div className="card-header bg-primary text-white">
              <h4 className="mb-0">{product?.name}</h4>
            </div>

            <div className="card-body">
              <div className="row">

                {/* Image */}
                <div className="col-md-5 text-center">
                  <img
                    src={product.imageUrl || "https://via.placeholder.com/300"}
                    className="img-fluid rounded"
                    alt={product.name}
                  />
                </div>

                {/* Info */}
                <div className="col-md-7">
                  <h5 className="text-success mb-3">
                    ₹ {product.price}
                  </h5>

                  <p className="text-muted">
                    {product.productAvailable ? "In Stock" : "Out of Stock"}
                  </p>

                  <ul className="list-group list-group-flush mb-3">
                    <li className="list-group-item">
                      <strong>Rating:</strong> ⭐ {product.starRating}
                    </li>
                  </ul>

                  {/* Actions */}
                  <div className="d-flex gap-2">
                    <button
                      className="btn btn-success"
                      onClick={() => addToCart(product)}
                    >
                      <i className="bi bi-cart-plus"></i> Add to Cart
                    </button>

                    <button className="btn btn-outline-secondary">
                      <i className="bi bi-heart"></i> Wishlist
                    </button>
                  </div>
                </div>

              </div>
            </div>
            </div>
            </div>
            </div>
                </div>
    );
}