$(document).ready(function () {
    var activeClass = 'active';
    var sideMenuClass = "side-menu-option"

    $(className(sideMenuClass)).on('click', function () {
        $(className(sideMenuClass)).each( function(index){
            if($(this).hasClass(activeClass))
                $(this).removeClass(activeClass);
        });
        $(this).addClass(activeClass);
    });

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    function className(name){ return '.' + name; };

});