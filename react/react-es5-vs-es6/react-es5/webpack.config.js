/**
 * Created by Logan on 2017/1/17.
 */
var path = require("path");

module.exports = {
    entry: path.resolve(__dirname, "src/index.js"),
    output: {
        path: path.resolve(__dirname, "dist"),
        filename: "bundle.js"
    },

    module: {
        loaders: [
            {
                test: /.js$/,
                exclude: /node_modules/,
                loader: "babel-loader",
                query: {
                    presets: ["react"]
                }
            }
        ]
    }
};