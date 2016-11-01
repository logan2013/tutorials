module.exports = {
	entry : "./src/index.js",
	output : {
		filename : "./dist/bundle.js"
	},
	module : {
		preLoaders : [ {
			test : /\.js$/,
			exclude: /node_modules/,
			loaders : [ 'eslint' ],
		} ],
		loaders: [ {
      test: /\.js$/,
      exclude: /node_modules/,
      loader: 'babel',
      query: {
        cacheDirectory: true,
        presets: ['es2015']
      }
    } ]
	}
};