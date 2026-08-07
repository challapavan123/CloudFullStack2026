import mongoose from "mongoose";
export const connectDB = async (mongoURI) => {
    try {
        await mongoose.connect(mongoURI);
        console.log("MongoDB connected successfully");
    }
    catch (error) {
        console.error("Error connecting to MongoDB:", error);
        process.exit(1); // Exit the process with failure
    }
};
//# sourceMappingURL=dbConfig.js.map