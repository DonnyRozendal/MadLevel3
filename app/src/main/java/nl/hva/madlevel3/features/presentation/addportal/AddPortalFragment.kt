package nl.hva.madlevel3.features.presentation.addportal

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*
import nl.hva.madlevel3.R
import nl.hva.madlevel3.core.extension.observe
import nl.hva.madlevel3.core.platform.BaseFragment
import nl.hva.madlevel3.features.data.models.Portal
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPortalFragment : BaseFragment() {

    private val viewModel by viewModel<AddPortalViewModel>()

    override fun layoutId() = R.layout.fragment_add_portal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            observe(added) { findNavController().navigateUp() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "AddPortal"
        initViews()
    }

    private fun initViews() {
        buttonAdd.setOnClickListener {
            val title = editTextTitle.text.toString()
            val url = editTextUrl.text.toString()
            viewModel.addPortal(Portal(null, title, url))
        }
    }

}