package com.example.pokebase

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.pokebase.models.NamedApiResource
import com.example.pokebase.models.Pokemon
import com.example.pokebase.models.adapters.PokeAdapter
import com.example.pokebase.models.adapters.PokeInterface
import com.example.pokebase.presenters.MainPresenter
import com.example.pokebase.presenters.view.MainView

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : MvpAppCompatActivity(), MainView, View.OnScrollChangeListener, PokeInterface {

    private var adapter: PokeAdapter = PokeAdapter(this)

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private lateinit var rvPoke: RecyclerView
    private lateinit var progBar: ProgressBar
    private lateinit var chbHp: CheckBox
    private lateinit var chbAttack: CheckBox
    private lateinit var chbDefence: CheckBox

    private var checkHp = false
    private var checkAttack = false
    private var checkDefence = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPoke = findViewById(R.id.rv_pokemons)
        progBar = findViewById(R.id.pg)

        chbHp = findViewById(R.id.chb_hp)
        chbAttack = findViewById(R.id.chb_attack)
        chbDefence = findViewById(R.id.chb_defence)

        rvPoke.layoutManager = when(resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> GridLayoutManager(this, 2)
            Configuration.ORIENTATION_LANDSCAPE -> GridLayoutManager(this, 4)
            else -> null
        }
        rvPoke.adapter = adapter
        rvPoke.setOnScrollChangeListener(this)
        presenter.getPokemons()

        chbHp.setOnCheckedChangeListener { _, isChecked ->
            checkHp = isChecked
            presenter.sortPokemons(
                chb_hp = checkHp,
                chb_attack = checkAttack,
                chb_defence = checkDefence
            )
        }
        chbAttack.setOnCheckedChangeListener { _, isChecked ->
            checkAttack = isChecked
            presenter.sortPokemons(
                chb_hp = checkHp,
                chb_attack = checkAttack,
                chb_defence = checkDefence
            )
        }
        chbDefence.setOnCheckedChangeListener { _, isChecked ->
            checkDefence = isChecked
            presenter.sortPokemons(
                chb_hp = checkHp,
                chb_attack = checkAttack,
                chb_defence = checkDefence
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateAdapter(list: List<NamedApiResource>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun showList() {
        progBar.visibility = View.GONE
        rvPoke.visibility = View.VISIBLE
    }

    override fun hideList() {
        progBar.visibility = View.VISIBLE
        rvPoke.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun scrollToStart() {
        rvPoke.scrollToPosition(0)
    }

    override fun onScrollChange(
        v: View?,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        val env = (rvPoke.layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition()
        if (env == presenter.getList().size - 1) presenter.getPokemons()
    }

    override fun clicked(id: Int) {
        DetailInfoFragment.newInstance(id).show(supportFragmentManager, null)
    }
}