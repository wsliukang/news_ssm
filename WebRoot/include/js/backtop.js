var $backtotop = $('#backtotop');
var toplrw = $(window).height() - $backtotop.height() - 200;
function moveBacktotop() {
	if (toplrw < 0)
		toplrw = 0;
	$backtotop.css({
		top : toplrw,
		right : 0
	});
}
$backtotop.click(function() {
	$('html,body').animate({
		scrollTop : 0
	});
	return false;
});
$(window).scroll(function() {
	var windowHeight = $(window).scrollTop();
	if (windowHeight > 200) {
		$backtotop.fadeIn();
	} else {
		$backtotop.fadeOut();
	}
});
moveBacktotop();
$(window).resize(moveBacktotop);