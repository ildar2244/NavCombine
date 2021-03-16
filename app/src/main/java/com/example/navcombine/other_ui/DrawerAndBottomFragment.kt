package com.example.navcombine.other_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.navcombine.R
import com.example.navcombine.databinding.FragmentDrawerAndBottomBinding
import com.example.navcombine.feature_home.BottomHomeFragment
import com.example.navcombine.feature_list.SideListFragment
import com.example.navcombine.feature_settings.SettingsFragment

class DrawerAndBottomFragment : Fragment() {

    private lateinit var mActivity: AppCompatActivity
    private lateinit var binding: FragmentDrawerAndBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentDrawerAndBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
    }

    private fun setupView(view: View) {

        mActivity = activity as AppCompatActivity
        mActivity.apply {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        //этот кусок куда превращает иконку "Стрелку Назад" в "Гамбургер"
        val drawerToggle = ActionBarDrawerToggle(
            activity, binding.drawerLayout, R.string.drawer_open, R.string.drawer_close
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //вешаем обработчики кликов Меню
        binding.navBottom.setOnNavigationItemSelectedListener {
            selectBottomItem(it)
            false
        }

        binding.navDrawer.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //клики Ниженее Меню
    private fun selectBottomItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.bottom_home -> {
                setTitleInToolbar("HOME")
                setFragment(BottomHomeFragment())
            }
            R.id.bottom_dashboard -> {
                setTitleInToolbar("Bottom 2")
                setFragment(Bottom2Fragment())
            }
            R.id.bottom_camera -> {
                setTitleInToolbar("Bottom 3")
                setFragment(Bottom3Fragment())
            }
        }
    }

    //клики Боковое Меню
    private fun selectDrawerItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.side_shop_cart -> {
                setTitleInToolbar("SIDE 1")
                setFragment(Side1Fragment())
            }
            R.id.side_list -> {
                setTitleInToolbar("Side LIST")
                setFragment(SideListFragment())
            }
            R.id.side_settings -> {
                setTitleInToolbar("Side SETTINGS")
                setFragment(SettingsFragment())
            }
        }
    }

    private fun setTitleInToolbar(name: String) {
        mActivity.supportActionBar?.title = name
    }

    private fun setFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.host_drawer_bottom, fragment)
            .commit()
    }
}