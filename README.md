# jungle-simulation

 1. Можно выбрать одну из экосистем, в которой будут разворачиваться события симулятора: джунгли, лес, океан или море.
 2. В выбраной экосистеме нужно создать хищника и огласить несколько видов пищи которую он может добывать в этой экосистеме.
 3. Хищнику надо задать три параметра, которые будут определять его жизнеспособность: здоровье, энергия и коэффициент пополнения энергии.
 4. С хищником могут происходить 10 событий, каждное из которых влияет на энергию и здоровье расписанным в событии образом. Коэффициент пополнения энергии - неизменяем.
 5. Нужно расписать детали событий и их влияние на здоровье и энергию, а так же придумать коэффициент таким образом, чтоб хищник жил какое то время и мог умереть.
 6. Нулевой уровень энергии понижает здоровье. Нулевой уровень здоровья приводит к немедленной смерти хищника.
 7. После расписания всех деталий событий и создания хищинка, нужно соорудить симулятор, где каждое из событий имеет рандомальный шанс случиться.
 8. Все события повторяются циклично пока хищник жив, все происходящие события выводятся текстом в терминал с временной задержкой.

 Мой выбор:

 Экосистема: Море
 Хищник: Акула (Shark)
 Варианты еды: рыба, кальмар, водоросли и планктон. (Fish, squid, seaweed, plankton)
 События/ методы:
 1. Акула спит (sleep)
 2. Акула ест рыбу (eatFish)
 3. Акула ест кальмара (eatSquid)
 4. Акула ест водоросли и планктон (eatSeaweedPlankton)
 5. Акула ест отходы: пластик, стекло, метал (eatTrash)
 6. Акула плывет в посиках добычи (searchPray)
 7. Акула мигрирует в стае (migrate)
 8. Акула размножается (spawn)
 9. Акула вырывается из крючка рыболова (breakFreeFromHook)
 10. Акула сражается с браконьером (battlePoacher)
