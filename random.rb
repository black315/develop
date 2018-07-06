print '選択肢の数を入力: '
num = gets.to_i

choice = Array.new(num)

for i in 1..num do
  print ("選択肢#{i}を入力: ")
  choice[i] = gets
end

result = rand(num) + 1

puts choice[result]
