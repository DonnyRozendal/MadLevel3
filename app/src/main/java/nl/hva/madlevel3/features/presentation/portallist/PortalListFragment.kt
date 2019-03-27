package nl.hva.madlevel3.features.presentation.portallist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_portal_list.*
import nl.hva.madlevel3.R
import nl.hva.madlevel3.core.extension.observe
import nl.hva.madlevel3.core.platform.BaseFragment
import nl.hva.madlevel3.features.data.models.Portal
import org.koin.androidx.viewmodel.ext.android.viewModel

class PortalListFragment : BaseFragment() {

    private val viewModel by viewModel<PortalListViewModel>()

    override fun layoutId() = R.layout.fragment_portal_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.apply {
            observe(portals, ::addButtons)
        }
        viewModel.getAllPortals()
    }

    private fun initViews() {
        buttonPlus.setOnClickListener {
            findNavController().navigate(R.id.action_portalListFragment_to_addPortalFragment)
        }
    }

    private fun addButtons(portals: Array<Portal>) {
        for (portal in portals) {
            val button = layoutInflater.inflate(R.layout.button, gridLayout, false) as Button
            button.text = portal.title
            button.setOnClickListener {
                val directions =
                    PortalListFragmentDirections.actionPortalListFragmentToWebViewFragment(
                        portal.url
                    )
                findNavController().navigate(directions)
            }
            gridLayout.addView(button)
        }
    }

}