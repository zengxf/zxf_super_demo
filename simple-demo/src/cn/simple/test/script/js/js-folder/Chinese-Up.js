function numberToChinese(input) {
    var fraction = ['角', '分'];
    var digit = [
        '零', '壹', '贰', '叁', '肆',
        '伍', '陆', '柒', '捌', '玖'
    ];
    var unit = [
        ['元', '万', '亿'],
        ['', '拾', '佰', '仟']
    ];
    var head = input < 0 ? '欠' : '';
    input = Math.abs(input);
    var s = '';
    for (var i = 0; i < fraction.length; i++) {
        s += (digit[Math.floor(input * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
    }
    s = s || '整';
    input = Math.floor(input);
    for (var i = 0; i < unit[0].length && input > 0; i++) {
        var p = '';
        for (var j = 0; j < unit[1].length && input > 0; j++) {
            p = digit[input % 10] + unit[1][j] + p;
            input = Math.floor(input / 10);
        }
        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
    }
    return head + s.replace(/(零.)*零元/, '元')
        .replace(/(零.)+/g, '零')
        .replace(/^整$/, '零元整');
}