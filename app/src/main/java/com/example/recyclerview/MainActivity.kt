package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.antman,
                "Ant-Man",
                "Scott Edward Harris Lang is a former convicted thief who was struggling to pay child support to his estranged wife for visitation rights to his daughter, Cassie Lang. With the promise of money, he was convinced by Hank Pym to take on the mantle of Ant-Man: a superhero with an advanced suit designed to shrink its wearer to a tiny size while increasing one's toughness, agility, and physical strength. Trained under both Pym and his daughter Hope van Dyne, Ant-Man was to help foil Pym's former protege Darren Cross, who was intending to sell his Yellowjacket Suit design and his copy of the Pym Particles formula to HYDRA and the Ten Rings. However, their plan was discovered by Cross, culminating in a final fight between Yellowjacket and Ant-Man. To defeat Yellowjacket, Ant-Man had to shrink small enough to enter Yellowjacket's suit and destroy it, sending Ant-Man to the Quantum Realm, but Ant-Man was able to escape. Ant-Man's heroism helped restore his relationship with Cassie and his ex-wife, as well as find a new romantic one with van Dyne. Lang soon learned that the Avengers were seeking to recruit him."
            ),
            Superhero(
                R.drawable.blackwidow,
                "Black Widow",
                "Natalia Alianovna \"Natasha\" Romanoff (Russian: Наталья Альяновна \"Наташа\" Романов) was one of the most talented spies and assassins in the entire world and a founding member of the Avengers. As a child, she was indoctrinated into the Red Room by General Dreykov, and briefly lived as the surrogate daughter of Alexei Shostakov and Melina Vostokoff while they were undercover in the United States of America. After the Destruction of the North Institute, she underwent extensive psychological conditioning, before graduating from the Red Room as a Widow. Working as an operative for the KGB, she was targeted by S.H.I.E.L.D., before given the chance to ultimately defect to the organization by Clint Barton by assassinating Dreykov. Romanoff succeeded, although having to use his daughter Antonia Dreykov's life as collateral damage would haunt her for the rest of her life."
            ),
            Superhero(
                R.drawable.blackpanther,
                "Black Panther",
                "King T'Challa was the King of Wakanda and the eldest child of T'Chaka and Ramonda who was chosen to be the holder of the Black Panther mantle. Following the death of his father in the bombing orchestrated by Helmut Zemo, T'Challa had set out to kill the Winter Soldier, who was widely believed to be responsible for the attack. During his attempt to find the Winter Soldier, Black Panther had joined a civil war between the Avengers, where he sided with Iron Man. However, when T'Challa learned that Zemo was the one who had been responsible for his father's demise, he captured Zemo and handed him over to Everett Ross, while he vowed never to allow desires of vengeance to consume him again."
            ),
            Superhero(
                R.drawable.captainamerica,
                "Captain America",
                "Captain Steven Grant \"Steve\" Rogers is a World War II veteran, a founding member of the Avengers, and Earth's first known superhero. Rogers grew up suffering from numerous health problems, and upon America's entry into World War II, he was rejected from serving in the United States Army despite several attempts to enlist. Rogers ultimately volunteered for Project Rebirth, where he was the only recipient of the Super Soldier Serum developed by Abraham Erskine under the Strategic Scientific Reserve. The serum greatly enhanced Rogers' physical abilities to superhuman levels. After Erskine's assassination and being doubted by SSR head director Chester Phillips, Rogers was relegated to performing in war bond campaigns, where he posed as a patriotic mascot under the moniker of Captain America."
            ),
            Superhero(
                R.drawable.captainmarvel,
                "Captain Marvel",
                "Carol Susan Jane Danvers is a former United States Air Force pilot who, upon being exposed to the energy of the Tesseract via the destruction of the Light-Speed Engine, obtained cosmic powers. She gained further powers when she was made into a Kree-human hybrid via a blood transfusion from Yon-Rogg, and had all of her old memories removed, turning her into the Kree's weapon and a member of Starforce. Now operating as Vers, she was captured by Skrulls during the Kree-Skrull War, resulting in her returning to Earth and beginning to recall her past, with help from Nick Fury and Maria Rambeau. Vers subsequently discovered that Yon-Rogg and the Kree Empire had been manipulating her for years, learning from Talos that the Skrulls were merely seeking to find a new home. With this information, Danvers, rejecting her Vers persona, unlocked her true powers and defeated the Kree invasion onto Earth that was being led by Ronan the Accuser, before setting off out to the far reaches of the galaxy to finish what her late mentor Mar-Vell had previously started, honoring her by becoming known as Captain Marvel."
            ),
            Superhero(
                R.drawable.doctorstrange,
                "Doctor Strange",
                "Doctor Stephen Vincent Strange, M.D., Ph.D. is a Master of the Mystic Arts. Originally a brilliant but arrogant neurosurgeon, Strange got into a car accident which resulted in his hands becoming crippled. Once Western medicine failed him, Strange embarked on a journey to Kamar-Taj, where he was trained by the Ancient One in the ways of Magic and the Multiverse. Although he focused on healing his hands, Strange was drawn into a conflict with Kaecilius and the Zealots, who were working for Dormammu and had sought to merge Earth with the Dark Dimension. Following the demise of the Ancient One and the defeat of Kaecilius, Strange then became the new protector of the Sanctum Sanctorum, seeking to defend the Earth from other inter-dimensional threats."
            ),
            Superhero(
                R.drawable.gamora,
                "Gamora",
                "Gamora Zen Whoberi Ben Titan was a former Zehoberei assassin and a former member of the Guardians of the Galaxy. She became the adopted daughter of Thanos and adopted sister of Nebula after he killed half of her race. Gamora served him for years before betraying him in an attempt to free herself from his ways. She was hired to steal the Orb, and after becoming involved in the Quest for the Orb, she befriended the other members of the Guardians of the Galaxy. After the Battle of Xandar, she left to work with them all. Having made a deal with the Sovereign to kill the Abilisk, Gamora was able to regain custody of Nebula with the intention of finally bringing her to justice in Xandar."
            ),
            Superhero(
                R.drawable.hawkeye,
                "Hawkeye",
                "Clinton Francis \"Clint\" Barton is an extremely skilled marksman, a former special agent of S.H.I.E.L.D. and one of the founding members of the Avengers. Known for his use of the bow and arrow as his primary weapon and an extremely keen eyesight and accuracy that earned him the codename Hawkeye, Barton had become one of the best S.H.I.E.L.D. agents, responsible for the recruitment of Black Widow, whom he developed a strong friendship with. Assigned by Nick Fury into watching over the Tesseract, he was brainwashed by Loki and used as his pawn in his attempt to become king of Midgard. However, following their Attack on the Helicarrier, he was freed from Loki's mental controls by Black Widow and joined the Avengers to fight against Loki and the Chitauri army in the battle of New York, ending Loki's invasion, before Hawkeye had returned to his work at a S.H.I.E.L.D.."
            ),
            Superhero(
                R.drawable.hulk,
                "Hulk",
                "Doctor Robert Bruce Banner, M.D., Ph.D., is a renowned scientist and a founding member of the Avengers. Highly respected for his work in biochemistry, nuclear physics and gamma radiation, Banner was tasked by Thaddeus Ross to recreate the Super Soldier Serum that created Captain America. However, Ross elected not to inform Banner what he was creating. During the experiment, Banner substituted vita radiation for gamma radiation and administered the serum on himself. As a result, the mild-mannered scientist found that when angered, provoked or excited, his body and brain would transform into a huge, rage-fueled, primitive-minded creature known as the Hulk."
            ),
            Superhero(
                R.drawable.ironman,
                "Iron Man",
                "Anthony Edward \"Tony\" Stark was a billionaire industrialist, a founding member of the Avengers, and the former CEO of Stark Industries. A brash but brilliant inventor, Stark was self-described as a genius, billionaire, playboy, and philanthropist. With his great wealth and exceptional technical knowledge, Stark was one of the world's most powerful men following the deaths of his parents and enjoyed the playboy lifestyle for many years until he was kidnapped by the Ten Rings in Afghanistan, while demonstrating a fleet of Jericho missiles. With his life on the line, Stark created an armored suit which he used to escape his captors. Upon returning home, he utilized several more armors to use against terrorists, as well as Obadiah Stane who turned against Stark. Following his fight against Stane, Stark publicly revealed himself as Iron Man."
            ),
            Superhero(
                R.drawable.loki,
                "Loki",
                "Loki Laufeyson was the biological son of Laufey, King of the Frost Giants, who was abandoned and left to die shortly after his birth. Found by Odin, Loki was taken to Asgard and raised by him and Frigga as an Asgardian prince, along with Thor, becoming the Asgardian God of Mischief. When Thor was to be crowned King, Loki had sabotaged the coronation by letting the Frost Giants attack Asgard, thus leading Thor to seek vengeance on Jotunheim, which resulted in Thor's banishment to Earth and Loki finding out the truth about his heritage. Frigga gave Loki the throne when Odin had fallen into the Odinsleep; however, when the Warriors Three and Sif attempted to return Thor home, Loki was forced to try to stop them. Regardless, Thor returned from his exile on Earth and ended Loki's reign, thwarting his attempt to declare war on the Nine Realms with Jotunheim's destruction. With Odin disapproving of his actions, Loki allowed himself to fall through the deep abyss of space, entering a wormhole created by the sudden termination of the Bifrost Bridge."
            ),
            Superhero(
                R.drawable.nebula,
                "Nebula",
                "Nebula is a former Luphomoid assassin, an adopted daughter of the intergalactic warlord Thanos and adopted sister of Gamora. As the right-hand woman of Ronan the Accuser during his and Thanos' quest to retrieve the Orb, she helped him fight the Guardians of the Galaxy during the Battle of Xandar. Fleeing the battle after a fight with Gamora, Nebula was soon captured by the Sovereign and handed back to the Guardians after a finished commission. She escaped and helped Taserface lead the other Ravagers in a mutiny against their former leader Yondu Udonta before leaving to find and kill Gamora. After forgiving and helping her sister alongside the Guardians during the Battle on Ego's Planet, she left in a ship to pursue a revenge mission against Thanos."
            )
        )

        binding.rvHero.layoutManager = LinearLayoutManager(this)
        binding.rvHero.setHasFixedSize(true)
        binding.rvHero.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent(this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}