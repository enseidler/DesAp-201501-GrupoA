'use strict';

/** 
**	FACEMED ACCORDION MENU
**  Forked from: http://www.learningjquery.com/2007/03/accordion-madness
**  Author: Ezequiel N. Seidler
**  Universidad Nacional de Quilmes	
*/

$(document).ready(function() {
	$('div.facemed-accordion div.panel div.panel-body').hide();  
	$('div.facemed-accordion div.panel div.panel-heading').click(function() {
	  	var $nextDiv = $(this).next('div.panel-body');
	  	var $visibleSiblings = $nextDiv.siblings('div.panel div.panel-body:visible');
		  
		if ($visibleSiblings.length ) {
	    	$visibleSiblings.slideUp('fast', function() {
	      		$nextDiv.slideToggle('fast');
	    	});
	  	} else {
	     	$nextDiv.slideToggle('fast');
	  	}
	});
});