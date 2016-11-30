// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require bootstrap.min.js
//= require jquery.min.js
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

<!-- Menu lateral quede activado -->

	  $(document).ready(function() {
	  $('li.active').removeClass('active');
	  $('a[href="' + location.pathname + '"]').closest('li').addClass('active'); 
	});

	 
      $(document).ready(function() {
          $(".numbers").each(function() {
              $(this).format({format:"#.###", locale:"us"});
          });
      });


