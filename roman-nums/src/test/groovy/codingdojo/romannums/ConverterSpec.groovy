package codingdojo.romannums

import spock.lang.Specification
import spock.lang.Unroll

class ConverterSpec extends Specification {

    @Unroll
    def 'test conversion from normal numbers to Roman numerals: scenario #num'() {
        when:
        def romanNum = Converter.toRomanNumeral(num)

        then:
        romanNum == expectedRomanNum

        where:
        num  || expectedRomanNum
        1    || 'I'
        5    || 'V'
        10   || 'X'
        50   || 'L'
        100  || 'C'
        500  || 'D'
        1000 || 'M'
        -1   || ''
        0    || ''
        2    || 'II'
        3    || 'III'
        4    || 'IV'
        6    || 'VI'
        7    || 'VII'
        8    || 'VIII'
        9    || 'IX'
        12   || 'XII'
        20   || 'XX'
        45   || 'XLV'
        49   || 'XLIX'
        253  || 'CCLIII'
        254  || 'CCLIV'
        833  || 'DCCCXXXIII'
        899  || 'DCCCXCIX'
        1981 || 'MCMLXXXI'
        3000 || 'MMM'
        3001 || ''
    }
}
