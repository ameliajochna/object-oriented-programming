#Amelia Jochna Lista 8 Zadanie 1

class Masa
    def initialize(masa_kg)
        @masa_kg = masa_kg
    end
  
    def kg
        @masa_kg
    end
  
    def kg=(masa)
        @masa_kg = masa
    end
  
    def funty
        @masa_kg * 2.20462262
    end
  
    def funty=(masa)
        @masa_kg = masa / 2.20462262
    end
  end
  
class Dlugosc
    def initialize(dlugosc_m)
        @dlugosc_m = dlugosc_m
    end
  
    def metry
        @dlugosc_m
    end
  
    def metry=(dlugosc)
        @dlugosc_m = dlugosc
    end
  
    def stopy
        @dlugosc_m * 3.2808399
    end
  
    def stopy=(dlugosc)
        @dlugosc_m = dlugosc / 3.2808399
    end
end
  
class Powierzchnia
    def initialize(dlugosc_m, szerokosc_m)
        @dlugosc_m = Dlugosc.new(dlugosc_m)
        @szerokosc_m = Dlugosc.new(szerokosc_m)
    end
    
    def hektar
        @hektar = (@dlugosc_m.metry * @szerokosc_m.metry) / 10000.0
    end

    def cal_kwadratowy
        @cal_kwadratowy = (@dlugosc_m.stopy * @szerokosc_m.stopy) / 144
    end
end

class Cisnienie
    def initialize(masa_kg, dlugosc_m, szerokosc_m)
        @masa = Masa.new(masa_kg)
        @powierzchnia = Powierzchnia.new(dlugosc_m, szerokosc_m)
    end

    def bary 
        sila = @masa.kg * 9.8
        (sila / (@powierzchnia.hektar * 1000000000.0))
    end

    def psi
        sila = @masa.funty * 2.203
        (sila / (@powierzchnia.cal_kwadratowy))
    end
end

powierzchnia = Powierzchnia.new(1000, 150)
puts "POWIERZCHNIA dla 1000 m na 150 m"
puts "SI: #{powierzchnia.hektar}"
puts "ANGLOSASKIE #{powierzchnia.cal_kwadratowy}"

cisnienie = Cisnienie.new(1000, 50, 70)
puts "CISNIENIE dla 1000 kg na 50 m na 70 m"
puts "SI: #{cisnienie.bary}"
puts "ANGLOSASKIE #{cisnienie.psi}"

