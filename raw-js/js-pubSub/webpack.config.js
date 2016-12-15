/**
 * Created by Logan on 2016/12/15.
 */
var path = require("path");

module.exports = {
    entry: path.join(__dirname, "src"),
    output: {
        path: path.join(__dirname, "public"),
        filename: "bundle.js",
        publicPath: path.join(__dirname, "public")
    },
    devServer: {
        contentBase: path.join(__dirname, "public")
    },
    module: {
        loaders: [
            {
                test: /.js$/,
                exclude: /node_modules/,
                loader: "babel",
                query: {
                    presets: ["es2015"]
                }
            }
        ]
    }
};