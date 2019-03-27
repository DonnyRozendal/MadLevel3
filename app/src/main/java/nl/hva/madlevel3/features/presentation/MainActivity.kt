package nl.hva.madlevel3.features.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import nl.hva.madlevel3.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        setToolbarTitles()
    }

    private fun setupNavigation() {
        setupActionBarWithNavController(findNavController(R.id.navHostFragment))
    }

    private fun setToolbarTitles() {
        findNavController(R.id.navHostFragment)
                .addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.portalListFragment -> { supportActionBar?.title = "StudentPortal" }
                R.id.webViewFragment -> { supportActionBar?.title = "StudentPortal" }
                R.id.addPortalFragment -> { supportActionBar?.title = "AddPortal" }
            }
        }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.navHostFragment).navigateUp()

}