$( document ).ready(function() {
    swapCheckbox($("#optionsRadios1"))
    
});

function swapCheckbox(input) {
    let inputTemp = $(input).val()

    $('#searchElement').find(':checkbox').each(function(){
        $(this).prop('checked', false)
        $(this).attr('disabled', true)
    });

    $('#searchElement').find("."+inputTemp+"-checkbox").each(function(){
        $(this).prop('checked', false)
        $(this).attr('disabled', false)
    });
}


function ReplaceImg(lui){
	$(lui).attr('src', 'ressource/img/no-image.png');
}