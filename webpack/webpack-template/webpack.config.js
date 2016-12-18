/**
 * Created by Administrator on 2016/12/18.
 */
var path = require("path");
var HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
    context: path.join(__dirname, "src"),
    entry: {
        app: "./app/app",
        about: "./about/about"
    },
    output: {
        path: path.join(__dirname, "dist"),
        filename: "[name].bundle.js"
    },
    module: {
        loaders: [{
            test: /\.js$/,
            loader: "babel",
            include: path.join(__dirname, "src")

        }]
    },
    devServer: {
        contentBase: path.join(__dirname, "dist"),
        inline: true,
        stats: "errors-only"
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.join(__dirname, "src", "index.html"),
            hash: true,
            chunks: ["app"]
        }),

        new HtmlWebpackPlugin({
            template: path.join(__dirname, "src", "index.html"),
            hash: true,
            filename: "about.html",
            chunks: ["about"]
        })
    ]
};