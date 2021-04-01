package kg.nurik.finalproject.ui.seasonDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentSeasonDetailsBinding
import kg.nurik.finalproject.utils.viewBinding

class SeasonDetailsFragment : Fragment(R.layout.fragment_season_details) {

    private val args: SeasonDetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentSeasonDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        Picasso.get().load(args.stats?.homeTeam?.logo).into(binding.itemCommands.imageHomeTeam)
        Picasso.get().load(args.stats?.awayTeam?.logo).into(binding.itemCommands.imageAwayTeam)

        binding.itemCommands.tvHomeTeam.text = args.stats?.homeTeam?.name
        binding.itemCommands.tvAwayTeam.text = args.stats?.awayTeam?.name

        binding.itemCommands.tvChetHomeTeam.text = args.stats?.stats?.homeScore.toString()
        binding.itemCommands.tvChetAwayTeam.text = args.stats?.stats?.awayScore.toString()

        binding.itemCommands.tvCityName.text  = args.stats?.venue?.city
        binding.itemCommands.tvVenueName.text  = args.stats?.venue?.name
        binding.itemCommands.tvCapacityChet.text  = args.stats?.venue?.capacity.toString()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}