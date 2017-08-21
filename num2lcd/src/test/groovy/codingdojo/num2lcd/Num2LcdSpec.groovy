package codingdojo.num2lcd

import spock.lang.Specification
import spock.lang.Unroll

class Num2LcdSpec extends Specification {

    @Unroll
    def 'test num 2 LCD conversion: scenario #num'() {
        when:
        def lcd = Num2Lcd.num2Lcd(num)

        then:
        lcd == expectedLcd

        where:
        num || expectedLcd
        1   || '    \n  | \n  | '
        2   || ' _  \n _| \n|_  '
        12  || '     _  \n  |  _| \n  | |_  '
        349 || ' _       _  \n _| |_| |_| \n _|   |  _| '
    }

    @Unroll
    def 'test num 2 digit conversion: scenario #num'() {
        when:
        def digits = Num2Lcd.num2Digits(num)

        then:
        digits == expectedDigits

        where:
        num || expectedDigits
        1   || '1'
        2   || '2'
        12  || '12'
        539 || '539'
    }
}
