package codingdojo.wordwrap

import spock.lang.Specification

class WrapperSpec extends Specification {

    def 'should not change the text if it is shorter than col'() {
        given:
        def text = 'Mary had a little lamb.'

        when:
        def out = Wrapper.wrap(text, 80)

        then:
        out == text
    }

    def 'should not allow lines longer than col'() {
        given:
        def text = 'aaaaaaaaaabbbbbbbbbbcccccccccc'

        when:
        def out = Wrapper.wrap(text, 10)

        then:
        out == 'aaaaaaaaaa\nbbbbbbbbbb\ncccccccccc'
    }

    def 'should trim boundary words'() {
        given:
        def text = 'aaaaa aaaaa aaaaa  bbbbb'

        when:
        def out = Wrapper.wrap(text, 20)

        then:
        out == 'aaaaa aaaaa aaaaa\nbbbbb'
    }

    def 'should try to wrap the text at word boundaries'() {
        given:
        def text = 'aaaaa aaaaa bbbbb bbbbb  ccccc ccccc  ddddddddddddddddddddd eeeeeeeeee eeeee e   ee'

        when:
        def out = Wrapper.wrap(text, 20)

        then:
        out == 'aaaaa aaaaa bbbbb\nbbbbb  ccccc ccccc\ndddddddddddddddddddd\nd eeeeeeeeee eeeee e\nee'
    }

    def 'should try to wrap the text at word boundaries - 2'() {
        given:
        def text = 'aaaaa aaaaa bbbbb bbbbb  ccccc ccccc  ddddddddddddddddddddd eeeeeeeeee eeeee ee   ee'

        when:
        def out = Wrapper.wrap(text, 20)

        then:
        out == 'aaaaa aaaaa bbbbb\nbbbbb  ccccc ccccc\ndddddddddddddddddddd\nd eeeeeeeeee eeeee\nee   ee'
    }

    def 'should correctly wrap long text'() {
        given:
        def text = '''Problem Description

You write a class called Wrapper, that has a single static function named wrap that takes two arguments, a string, and a column number. The function returns the string, but with line breaks inserted at just the right places to make sure that no line is longer than the column number. You try to break lines at word boundaries.

Like a word processor, break the line by replacing the last space in a line with a newline.'''

        when:
        def out = Wrapper.wrap(text, 80)

        then:
        out == '''Problem Description

You write a class called Wrapper, that has a single static function named wrap
that takes two arguments, a string, and a column number. The function returns
the string, but with line breaks inserted at just the right places to make sure
that no line is longer than the column number. You try to break lines at word
boundaries.

Like a word processor, break the line by replacing the last space in a line with
a newline.'''
    }

    def 'should not trim new line in the text'() {
        given:
        def text = 'My Holidays\n\n\nI went to the beach.'

        when:
        def out = Wrapper.wrap(text, 20)

        then:
        out == 'My Holidays\n\n\nI went to the beach.'
    }

}
