/**
 * 
 */
requirejs.config({
	paths: {
		/**
		 * the left side is the module ID
		 * 
		 * the right side is the path
		 */
		jquery: "jquery.v1.8.3"
	}
});

require(["purchase", "jquery"], function(purchase, $$) {
	
	$$("#hello").text("world");
	
	purchase.purchaseProduct();
});