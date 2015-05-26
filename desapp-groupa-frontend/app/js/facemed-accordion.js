'use strict';

/** 
**	FACEMED ACCORDION
**  Forked from: http://www.learningjquery.com/2007/03/accordion-madness
**  Author: Ezequiel N. Seidler
**  Universidad Nacional de Quilmes	
*/

$(document).ready(function() {
	
	$('div.facemed-accordion-body').hide();  
	
	$('div.facemed-accordion-option').click(function() {
	  	var $nextDiv = $(this).next('div.facemed-accordion-body');
		$nextDiv.slideToggle('fast');
	});

});