 $("#login-button").click(function(event){
		 event.preventDefault();
	 setTimeout("document.location = 'login.html'",1000);
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
 });
/*
 $("#singin-button").click(function(event){
		 event.preventDefault();
	 setTimeout("document.location = 'sing-in.html'",1000);
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
});
*/
 $("#senha-link").click(function(event){
 	event.preventDefault();
 	setTimeout("document.location = 'login.html'",1000);
 	$('from').fadeOut(500);
 	$('.wrapper').addClass('form-success')
 });