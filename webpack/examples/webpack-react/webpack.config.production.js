"use strict";

var webpack = require("webpack");
var HtmlWebpackPlugin = require("html-webpack-plugin");
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
    entry: ["./src/index.jsx"],
    output: {
        path: __dirname + "/deploy",
        filename: "./bundle.js"
    },
    module: {
        loaders: [
          {
            test: /\.css$/,
            loader: ExtractTextPlugin.extract("style-loader", "css-loader")
          },
          {
            test: /\.jsx$/,
            loader: "babel"
          }
        ]
    },
    plugins: [
        new ExtractTextPlugin("styles.css"),
        new HtmlWebpackPlugin({
            template: "./src/index.html"
        })
    ]
};