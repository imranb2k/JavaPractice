/* 
 * IA JavaScript API
 *
 * Author:     Asylum Services
 * Version:    0.0.2
 */

(function (window, $, undefined) {
	var ia = {
		// 1. Initialisation
		init : function() {
			var $inDevelopment = $('.in-development') || [],
				$checkboxes = $('input[type="checkbox"]') || [];

			if ( $inDevelopment ) $inDevelopment.on('click', ia.notify.inDevelopment);
			if ( $checkboxes ) ia.checkboxes($checkboxes);
		},
		//omg this is SO hacky, but it's needed - ASAP.
		checkboxes : function ($checkboxes) {
			$.each($checkboxes, function(index, value) {
				if( $(this).attr('data-state') == 'true' ) {
					$(this).prop('checked', true);
				} else {
					$(this).prop('checked', false);
				}
			});
		},
		// 2. UI notifications
		notify : {
			inDevelopment : function() {
				$('#dialog-in-development').dialog({
						modal: true,
						buttons: {
						Ok: function() {
						  $( this ).dialog( "close" );
						}
					}
				});
			return false;
			}
		}
	}

	//Run
	ia.init();
	window.IA = ia;

}(window, jQuery));
