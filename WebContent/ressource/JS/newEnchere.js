function readURL(input) {
    var url = input.value;
    var ext = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
    if (input.files && input.files[0]&& (ext == "png" || ext == "jpeg" || ext == "jpg")) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#imgEnchere').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }else{
        $('#imgEnchere').attr('src', 'ressource/img/error.gif');
        $(input).addClass("is-invalid")
    }
}