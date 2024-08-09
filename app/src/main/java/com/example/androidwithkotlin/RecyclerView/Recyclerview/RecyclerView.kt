package com.example.androidwithkotlin.RecyclerView.Recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CustomAdapter(createAnimalList()) { animal, position ->
                Toast.makeText(
                    this@RecyclerView,
                    "Clicked on animal : ${animal.name}",
                    Toast.LENGTH_SHORT
                ).show()

            }
//            val divider = DividerItemDecoration(
//                baseContext,
//                (layoutManager as LinearLayoutManager).orientation
//            )
//            divider.setDrawable(AppCompatResources.getDrawable(context, R.drawable.divider)!!)
//            addItemDecoration(divider)
            //  addItemDecoration(RecyclerViewItemDecoration(context, R.drawable.divider))
        }
    }

    private fun createAnimalList(): ArrayList<Animal> {
        return arrayListOf<Animal>(
            Animal(
                "Antilope",
                R.drawable.antilope,
                "Antilope is a genus of bovid that contains a single living species, the blackbuck of South Asia. Two extinct species are also known."
            ),
            Animal(
                "Bear",
                R.drawable.bear,
                "Bears are carnivoran mammals of the family Ursidae. They are classified as caniforms, or doglike carnivorans. Although only eight species of bears are extant, they are widespread, appearing in a wide variety of habitats throughout the Northern Hemisphere and partially in the Southern Hemisphere"
            ),
            Animal(
                "Bison",
                R.drawable.bison,
                "Bison are large, even-toed ungulates in the genus Bison within the subfamily Bovinae. Two extant and six extinct species are recognised. Of the six extinct species, five became extinct in the Quaternary extinction event. Bison palaeosinensis evolved in the Early Pleistocene in South Asia, and was the evolutionary ancestor of B. priscus (steppe bison), which was the ancestor of all other Bison species."
            ),
            Animal(
                "Buffalo",
                R.drawable.buffalo,
                "Buffalo is the second-largest city in the U.S. state of New York and the seat of Erie County. It is at the eastern end of Lake Erie, at the head of the Niagara River, and is next to the Canadian border in southern Ontario. With a population of 278,349 according to the 2020 census, Buffalo is the 76th-largest city in the United States."
            ),
            Animal(
                "Camel",
                R.drawable.camel,
                "A camel is an even-toed ungulate in the genus Camelus that bears distinctive fatty deposits known as \"humps\" on its back. Camels have long been domesticated and, as livestock, they provide food (milk and meat) and textiles (fiber and felt from hair). Camels are working animals especially suited to their desert habitat and are a vital means of transport for passengers and cargo."
            ),
            Animal(
                "Cheetah",
                R.drawable.cheetah,
                "The cheetah (Acinonyx jubatus) is a large cat native to Africa and central Iran. It is the fastest land animal, estimated to be capable of running at 80 to 128 km/h (50 to 80 mph) with the fastest reliably recorded speeds being 93 and 98 km/h (58 and 61 mph), and as such has several adaptations for speed, including a light build, long thin legs and a long tail. It typically reaches 67–94 cm (26–37 in) at the shoulder, and the head-and-body length is between 1.1 and 1.5 m (3 ft 7 in and 4 ft 11 in)"
            ),
            Animal(
                "Cow",
                R.drawable.cow,
                "Cattle, taurine cattle, Eurasian cattle, or European cattle (Bos taurus or Bos primigenius taurus) are large domesticated cloven-hooved herbivores. They are a prominent modern member of the subfamily Bovinae and the most widespread species of the genus Bos."
            ),
            Animal(
                "Crocodile",
                R.drawable.crocodile,
                "Crocodiles (family Crocodylidae) or true crocodiles are large semiaquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia. The term crocodile is sometimes used even more loosely to include all extant members of the order Crocodilia, which includes the alligators and caimans (family Alligatoridae), the gharial and false gharial (family Gavialidae), and all other living and fossil Crocodylomorpha."
            ),
            Animal(
                "Deer",
                R.drawable.deer,
                "Deer or true deer are hoofed ruminant mammals forming the family Cervidae. The two main groups of deer are the Cervinae, including the muntjac, the elk (wapiti), the red deer, and the fallow deer; and the Capreolinae, including the reindeer (caribou), white-tailed deer, the roe deer, and the moose"
            ),
            Animal(
                "Elephant",
                R.drawable.elephant,
                "Elephants are the largest existing land animals. Three living species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant. They are an informal grouping within the proboscidean family Elephantidae."
            ),
            Animal(
                "Fox",
                R.drawable.fox,
                "Foxes are small to medium-sized, omnivorous mammals belonging to several genera of the family Canidae. They have a flattened skull, upright triangular ears, a pointed, slightly upturned snout, and a long bushy tail. Twelve species belong to the monophyletic \"true foxes\" group of genus Vulpes."
            ),
            Animal(
                "Giraffe",
                R.drawable.giraffe,
                "The giraffe is a tall African mammal belonging to the genus Giraffa. Specifically, It is an even-toed ungulate. It is the tallest living terrestrial animal and the largest ruminant on Earth. Traditionally, giraffes were thought to be one species, Giraffa camelopardalis, with nine subspecies."
            ),
            Animal(
                "Goat",
                R.drawable.goat,
                "The mountain goat (Oreamnos americanus), also known as the Rocky Mountain goat, is a hoofed mammal endemic to mountainous areas of western North America. A subalpine to alpine species, it is a sure-footed climber commonly seen on cliffs and ice."
            ),
            Animal(
                "Hedgehog",
                R.drawable.hedgehog,
                "A hedgehog is a spiny mammal of the subfamily Erinaceinae, in the eulipotyphlan family Erinaceidae. There are seventeen species of hedgehog in five genera found throughout parts of Europe, Asia, and Africa, and in New Zealand by introduction."
            ),
            Animal(
                "Hippo",
                R.drawable.hippo,
                "The hippopotamus, also called the hippo, common hippopotamus or river hippopotamus, is a large, mostly herbivorous, semiaquatic mammal and ungulate native to sub-Saharan Africa. It is one of only two extant species in the family Hippopotamidae, the other being the pygmy hippopotamus"
            ),
            Animal(
                "Horse",
                R.drawable.horse,
                "The horse is a domesticated one-toed hoofed mammal. It belongs to the taxonomic family Equidae and is one of two extant subspecies of Equus ferus. The horse evolved over the past 45 to 55 million years from Eohippus, a small multi-toed creature, into the large, single-toed animal of today."
            ),
            Animal(
                "Hyena",
                R.drawable.hyena,
                "Hyenas, or hyaenas, are feliform carnivoran mammals of the family Hyaenidae. With only four extant species, it is the fifth-smallest biological family in the Carnivora and one of the smallest in the class Mammalia. Despite their low diversity, hyenas are unique and vital components of most African ecosystems."
            ),
            Animal(
                "Jackal",
                R.drawable.jackal,
                "Jackals are medium-sized omnivorous mammals of the subtribe Canina, which also includes wolves and the domestic dog, among other species."
            ),
            Animal(
                "Kangaroo",
                R.drawable.kangaroo,
                "The kangaroo is a marsupial from the family Macropodidae. In common use the term is used to describe the largest species from this family, the red kangaroo, as well as the antilopine kangaroo, eastern grey kangaroo, and western grey kangaroo. Kangaroos are indigenous to Australia and New Guinea."
            ),
            Animal(
                "Koala",
                R.drawable.koala,
                "The koala or, inaccurately, koala bear, is an arboreal herbivorous marsupial native to Australia. It is the only extant representative of the family Phascolarctidae and its closest living relatives are the wombats, which are members of the family Vombatidae."
            ),
            Animal(
                "Lion",
                R.drawable.lion,
                "The lion is a large cat of the genus Panthera native to Africa and India. It has a muscular, deep-chested body, short, rounded head, round ears, and a hairy tuft at the end of its tail. It is sexually dimorphic; adult male lions are larger than females and have a prominent mane."
            ),
            Animal(
                "Monkey",
                R.drawable.monkey,
                "Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, also known as the simians. "
            ),
            Animal(
                "Panda",
                R.drawable.panda,
                "The giant panda, also known as the panda bear, is a bear native to South Central China. It is characterised by its bold black-and-white coat and rotund body. The name \"giant panda\" is sometimes used to distinguish it from the red panda, a neighboring musteloid."
            ),
            Animal(
                "Panther",
                R.drawable.panther,
                "A black panther is the melanistic colour variant of the leopard and the jaguar. Black panthers of both species have excess black pigments, but their typical rosettes are also present."
            ),
            Animal(
                "Porcupine",
                R.drawable.porcupine,
                "Porcupines are large rodents with coats of sharp spines, or quills, that protect them against predation. The term covers two families of animals: the Old World porcupines of family Hystricidae, and the New World porcupines of family Erethizontidae."
            ),
            Animal(
                "Rabbit",
                R.drawable.rabbit,
                "Rabbits, also known as bunnies or bunny rabbits, are small mammals in the family Leporidae (along with the hare) of the order Lagomorpha (along with the pika). Oryctolagus cuniculus includes the European rabbit species and its descendants, the world's 305 breeds[1] of domestic rabbit. Sylvilagus includes 13 wild rabbit species, among them the seven types of cottontail."
            ),
            Animal(
                "Racoon",
                R.drawable.racoon,
                "The raccoon, sometimes called the common raccoon to distinguish it from other species, is a medium-sized mammal native to North America. It is the largest of the procyonid family, having a body length of 40 to 70 cm, and a body weight of 5 to 26 kg."
            ),
            Animal(
                "Rhino",
                R.drawable.rhino,
                "A rhinoceros, commonly abbreviated to rhino, is a member of any of the five extant species of odd-toed ungulates in the family Rhinocerotidae. Two of the extant species are native to Africa, and three to South and Southeast Asia."
            ),
            Animal(
                "Squirrel",
                R.drawable.squirrel,
                "Squirrels are members of the family Sciuridae, a family that includes small or medium-size rodents. The squirrel family includes tree squirrels, ground squirrels, chipmunks, marmots, flying squirrels, and prairie dogs amongst other rodents."
            ),
            Animal(
                "Stag",
                R.drawable.stag,
                "Deer or true deer are hoofed ruminant mammals forming the family Cervidae. The two main groups of deer are the Cervinae, including the muntjac, the elk (wapiti), the red deer, and the fallow deer; and the Capreolinae, including the reindeer (caribou), white-tailed deer, the roe deer, and the moose."
            ),
            Animal(
                "Tiger",
                R.drawable.tiger,
                "The tiger is the largest living cat species and a member of the genus Panthera. It is most recognisable for its dark vertical stripes on orange fur with a white underside. An apex predator, it primarily preys on ungulates such as deer and wild boar."
            ),
            Animal(
                "Zebra",
                R.drawable.zebra,
                "Zebras are African equines with distinctive black-and-white striped coats. There are three living species: the Grévy's zebra, plains zebra, and the mountain zebra. Zebras share the genus Equus with horses and asses, the three groups being the only living members of the family Equidae."
            )
        )
    }
}