$(document).ready(function () {

    $('.table .pBtn').on('click',function (event) {

        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href,function (BillInfo,status) {
           $('.myForm #billNumber').val(BillInfo.billNumber);

        });
        $('.myForm #exampleModal').modal();
    });
});