var path = require("path");

module.exports = {
    entry: {
        "bundle": "./app/index"
    },
    output: {
        path: path.join(__dirname, "build"),
        filename: "[name].js"
    },
    module: {
        loaders: [
            {
                test: /.jsx?$/,
                loader: "babel-loader",
                include: path.join(__dirname, "app"),
                query: {
                    cacheDirectory: true,
                    presets: ["es2015", "react"]
                }
            }
        ]    
    },
    devServer: {
        contentBase: path.join(__dirname, "build")
    }
};