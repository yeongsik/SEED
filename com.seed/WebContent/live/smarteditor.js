//전역변수
var oEditors = [];

//스마트에디터 프레임생성
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "smartEditor",
	sSkinURI: "../SE2/SmartEditor2Skin.html",
	fCreator: "createSEditor2",
	htParams: {
		// 툴바 사용 여부
		bUseToolbar: true,
		// 입력창 크기 조절바 사용 여부
		bUseVerticalResizer: true,
		// 모드 탭(Editor | HTML | TEXT) 사용 여부
		bUseModeChanger: true,
		// 페이지에서 나가기 alert 안보이게 설정
		fOnBeforeUnload: function() { }

	}
});
 
//네이버 에디터 작성 데이터 전송하기 
$("#submit_btn").click(function() {
	oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
});