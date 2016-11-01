const path = require("path");
const merge = require("webpack-merge");
const webpack = require("webpack");
const NpmInstallPlugin = require("npm-install-webpack-plugin");

const TARGET = process.env.npm_lifecyle_event;
const PATHS = {
	app: path.join(__dirname, "app"),
	build: path.join(__dirname, "build")
};

const common = {
	/**
	*  
	* Entry accepts a path or an object or entries.
	* We will be using the later form given its convenient with more complex configuration.
	* 
	*/ 
	entry: {
		app: PATHS.app
	},
	output: {
		path: PATHS.build,
		filename: "bundle.js"
	},
	
	module: {
		loaders: [{
			test: /\.css$/,
			loaders: ["style", "css"],
			// include可以接收单个路径或者一个路径的数组
			include: PATHS.app
		}]
	}
};

// 默认配置
if (TARGET == "start" || !TARGET) {
	module.exports = merge(common, {
		devtool: "eval-source-map",
		devServer: {
			contentBase: PATHS.build,
			/**
			 * Enable history API fallback so HTML5 History API based
			 * routing works. This is a good default that will come
			 * in handy in more complicated setups.
			 */
			historyApiFallback: true,
			hot: true,
			inline: true,
			
			// 仅显示错误，这样减少输出数量
			status: "erros-only",
			
			// Parse host and port from env so this is easy to customize
			host: process.env.HOST,
			port: process.env.PORT
		},
		plugins: [
		    new webpack.HotModuleReplacementPlugin(),
		    new NpmInstallPlugin({
		    	save: true
		    })
		]
	});
}

if (TARGET == "build") {
	module.exports = merge(common, {});
}