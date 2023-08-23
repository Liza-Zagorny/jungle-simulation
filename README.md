# Jungle simulation: rules EN

1. Choose one ecosystem for simulation: jungle, forest, ocean or sea.
2. In the chosen ecosystem create a predator and name several options for its food.
3. The predator will be given three parameters that will determine its vitality: health, energy and health recovery rate.
4. There are 10 events that may happen to the predator, each impacting energy and health levels in as described bellow.
   The health recovery rate is constant.
5. Describe details of each event and their impact and declare the health recovery rate, so the predator will live for some time and
 have a chance of dying.
6. A zero energy level will decrease health. Zero health leads to immediate death of the predator.
7. After all events and the predator are created, build a simulator, where each event has a random chance of happening.
8. All events repeat in a cycle while the predator is alive and are printed to the terminal.

## My choice:

**Ecosystem:** Sea;
**Predator:** Shark;
**Food options:** Fish, squid, seaweed, plankton;

### Events and their probabilities:

1. Sleeping (sleep) - 20% (0-20)
2. Eating fish (eatFish) - 5% (20-25)
3. Eating squid (eatSquid) - 10% (25-35)
4. Eating seaweed and plankton (eatSeaweedPlankton) - 10% (35-45)
5. Eating sea trash: plastic, glass, metal (eatTrash) - 5% (45-50). With a 5% probability the shark dies after eating
   trash.
6. Looking for pray  (searchPray) - 35% (50-85)
7. Migrating in a flock (migrate) -10% (85-95)
8. Spawns (spawn) - 2% (95-97)
9. Breaking free from a fisherman's hook  (breakFreeFromHook) - 2%(97-99)
10. Fighting a poacher (battlePoacher) - 1% (99-100)

# Симуляция джунглей: правила RU

1. Можно выбрать одну из экосистем, в которой будут разворачиваться события симулятора: джунгли, лес, океан или море.
2. В выбраной экосистеме нужно создать хищника и огласить несколько видов пищи которую он может добывать в этой
   экосистеме.
3. Хищнику надо задать три параметра, которые будут определять его жизнеспособность: здоровье, энергия и коэффициент
   восполнения здоровья.
4. С хищником могут происходить 10 событий, каждное из которых влияет на энергию и здоровье расписанным в событии
   образом. Коэффициент пополнения энергии - неизменяем.
5. Нужно расписать детали событий и их влияние на здоровье и энергию, а так же придумать коэффициент таким образом, чтоб
   хищник жил какое то время и мог умереть.
6. Нулевой уровень энергии понижает здоровье. Нулевой уровень здоровья приводит к немедленной смерти хищника.
7. После расписания всех деталий событий и создания хищинка, нужно соорудить симулятор, где каждое из событий имеет
   рандомальный шанс случиться.
8. Все события повторяются циклично пока хищник жив, все происходящие события выводятся текстом в терминал.

## Мой выбор:

**Экосистема:** Море;
**Хищник:** Акула (Shark);
**Варианты еды:** Рыба, кальмар, водоросли и планктон. (Fish, squid, seaweed, plankton);

### События/ методы и их вероятности:

1. Акула спит (sleep) - 20% (0-20)
2. Акула ест рыбу (eatFish) - 5% (20-25)
3. Акула ест кальмара (eatSquid) - 10% (25-35)
4. Акула ест водоросли и планктон (eatSeaweedPlankton) - 10% (35-45)
5. Акула ест отходы: пластик, стекло, метал (eatTrash) - 5% (45-50). С вероятностью 5% у акулы случается осложнение
   после поедания отходов и она тут же умирает.
6. Акула плывет в поисках добычи (searchPray) - 35% (50-85)
7. Акула мигрирует в стае (migrate) -10% (85-95)
8. Акула размножается (spawn) - 2% (95-97)
9. Акула вырывается из крючка рыболова (breakFreeFromHook) - 2%(97-99)
10. Акула сражается с браконьером (battlePoacher) - 1% (99-100)
