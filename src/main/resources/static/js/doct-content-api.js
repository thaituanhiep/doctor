var doctorCode = $(location).attr('href').split('/id/')[1];

$.ajax({
    url: '/api/doctor/id/' + doctorCode,
    type: 'GET',
    success: function (data) {
        $('.doct-education').text(data.education);
        $('.doct-name').text(data.name);
        $('.doct-list-link').attr('href', '/doctors');
        $('.doct-image').attr('src', data.imageProfile);
        $('.doct-about').text(data.about);
        $.each(data.specialities.split(';'), function (i, item) {
            var newListItem = '<li>' + item + '</li>';
            $('#doct-specs').append(newListItem);
        })
    }
});

$.ajax({
    url: '/api/award/doctor/' + doctorCode,
    type: 'GET',
    success: function (data) {
        $.each(data, function (i,item) {
            var newOrderListItem = '<ol>' + item.name + '</ol>';
            $('#doct-awards-div').removeClass('hidden');
            $('#doct-awards').append(newOrderListItem);
        })

    }
});

$.ajax({
    url: '/api/exper/doctor/' + doctorCode,
    type: 'GET',
    success: function (data) {
        $.each(data, function (i, item) {
            var newSpan = '<p><span>' + item.content + '</span></p>';
            $('#doct-expers').append(newSpan);
        })
    }
});
