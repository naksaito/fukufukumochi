$(document).ready(function() {
	$('#slider').coinslider({
		width: 620, // width of slider panel
		height: 400, // height of slider panel
		spw: 10, // squares per width
		sph: 4, // squares per height
		delay: 5000, // delay between images in ms
		sDelay: 10, // delay beetwen squares in ms [default30]
		opacity: 0.5, // opacity of title and navigation
		titleSpeed: 500, // speed of title appereance in ms
		effect: 'random', // random, swirl, rain, straight
		navigation: false, // prev next and buttons
		links : false, // show images as links
		hoverPause: false // pause on hover		
	});
});
