requirejs.config( {
	"baseUrl": "/static",
	"paths": {
		"jquery":               "libs/jquery/jquery-2.0.3.min",
		"bootstrap":            "libs/bootstrap/js/bootstrap.min",
		"zebra-dialog":			"libs/Zebra_Dialog/js/zebra_dialog",
		"WdatePicker":   		"libs/My97DatePicker/WdatePicker",
		"common":               "js/common",
		"juw":           "libs/jqueryFileUpload/js/vendor/jquery.ui.widget",
		"jqIFrameTransport":    "libs/jqueryFileUpload/js/jquery.iframe-transport",
		"jqFileupload":         "libs/jqueryFileUpload/js/jquery.fileupload",
		"jqFileuploadProcess":  "libs/jqueryFileUpload/js/jquery.fileupload-process",
		"jqFileuploadImage":    "libs/jqueryFileUpload/js/jquery.fileupload-image",
		"jqFileuploadAudio":    "libs/jqueryFileUpload/js/jquery.fileupload-audio",
		"jqFileuploadVideo":    "libs/jqueryFileUpload/js/jquery.fileupload-video",
		"loadImageAll":         "libs/jqueryFileUpload/js/load-image.all",
		"loadimage":            "libs/jqueryFileUpload/js/load-image",
		"canvasToBlob":         "libs/jqueryFileUpload/js/canvas-to-blob.min",
		"jqFileuploadValidate": "libs/jqueryFileUpload/js/jquery.fileupload-validate"

	},
	"shim": {
		"bootstrap":            ["jquery"],
		"zebra-dialog":			["jquery"],
		"WdatePicker":			["jquery"],
		"common":               ["jquery","zebra-dialog"],
		"juw":					["jquery"],
		//"jqFileupload":			["jqUiWidget"],
		"jqFileuploadProcess":  ["jqFileupload","juw"],
		"jqFileuploadImage":    ["jqFileuploadProcess","loadimage"]

/*		"jqIFrameTransport":    ["jquery"],
		"jqFileupload":         ["jquery"],
,

		"jqFileuploadAudio":    ["jquery"],
		"jqFileuploadVideo":    ["jquery"],
		"loadImageAll":         ["jquery"],
		"canvasToBlob":         ["jquery"],
		"jqFileuploadValidate": ["jquery"]*/
		
	}
});