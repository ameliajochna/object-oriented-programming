#Amelia Jochna Lista 8 Zadanie 4

class Jawna
    def initialize(tekst)
        @tekst = tekst
    end

    def to_s
        @tekst
    end

    def zaszyfruj(key)
        s = ''
        @tekst.each_char do |c|
            s += key[c]
        end
        Zaszyfrowana.new(s)
    end
end

class Zaszyfrowana
    def initialize(napis)
        @napis = napis
    end

    def to_s
        @napis
    end

    def odszyfruj(key)
        s = ''
        @napis.each_char do |c|
            s += key.key(c)
        end
        Jawna.new(s)
    end
end

key = {
    'a' => 't', 
    'b' => 'd', 
    'c' => 'f',
    'x' => 'y'
}

jawny_tekst = Jawna.new("abcx")
puts "Tekst jawny: #{jawny_tekst.to_s()}"

zaszyfrowany_tekst = jawny_tekst.zaszyfruj(key)
puts "Tekst zaszyfrowany: #{zaszyfrowany_tekst.to_s()}"

odszyfrowany_tekst = zaszyfrowany_tekst.odszyfruj(key)
puts "Tekst odszyfrowany: #{odszyfrowany_tekst.to_s()}"


