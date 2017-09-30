//<![CDATA[
jQuery(window).load(function(){
    var step = 900;
    var scrolling = false;
    
    $(document).ready(function() {
    	
    });
    
    // Wire up events for the 'scrollUp' link:
    jQuery("#scrollLeft").bind("mousedown", function(event) {
    	event.preventDefault();
        /* Animates the scrollTop property by the specified step.*/
        jQuery("#content").animate({
            scrollLeft: "-=" + step + "px"
        });
    }).bind("mousedown", function(event) {
        scrolling = true;
        scrollContent("left");
    }).bind("mouseup", function(event) {
        scrolling = false;
    });


    jQuery("#scrollRight").bind("mousedown", function(event) {
    	event.preventDefault();
        jQuery("#content").animate({
            scrollLeft: "+=" + step + "px"
        });
    }).bind("mousedown", function(event) {
        scrolling = true;
        scrollContent("right");
    }).bind("mouseup", function(event) {
        scrolling = false;
    });

    function scrollContent(direction) {
        var amount = (direction === "left" ? "-=100px" : "+=100px");
        jQuery("#content").animate({
            scrollLeft: amount
        }, 1, function() {
            if (scrolling) {
                scrollContent(direction);
            }
        });
    }
});
//]]>