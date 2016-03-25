/**
 * Created by 燕晶 on 2016/3/24.
 */
    //这用了原生js代码，我没时间看，所以并不懂各部分的功能，没法注释
var loadImageFile = (function () {
    if (window.FileReader) {
        var	oPreviewImg = null, oFReader = new window.FileReader(),
            rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

        oFReader.onload = function (oFREvent) {
            if (!oPreviewImg) {
                var newPreview = document.getElementById("imagePreview");
                oPreviewImg = new Image();
                oPreviewImg.style.width = (newPreview.offsetWidth).toString() + "px";
                oPreviewImg.style.height = (newPreview.offsetHeight).toString() + "px";
                newPreview.appendChild(oPreviewImg);
            }
            oPreviewImg.src = oFREvent.target.result;
        };

        return function () {
            var aFiles = document.getElementById("imageInput").files;
            if (aFiles.length === 0) { return; }
            if (!rFilter.test(aFiles[0].type)) { alert("You must select a valid image file!"); return; }
            oFReader.readAsDataURL(aFiles[0]);
        }

    }
    if (navigator.appName === "Microsoft Internet Explorer") {
        return function () {
            var extArray = new Array(".gif", ".jpg", ".png",".jpeg");
            var file = document.getElementById("imageInput").value;
            var file1 = file.slice(file.indexOf("\\") + 1);
            var ext = file1.slice(file1.indexOf(".")).toLowerCase();
            var allowSubmit = false;
            for (var i = 0; i < extArray.length; i++)
            {
                if (extArray[i] == ext) {
                    allowSubmit = true;
                    break;
                }
            }
            if (!allowSubmit){
                alert("You must select a valid image file!");
                return;
            }
            document.getElementById("imagePreview").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = file;
        }
    }
})();
